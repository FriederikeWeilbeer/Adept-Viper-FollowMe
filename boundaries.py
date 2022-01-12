import socket

input_messages = [b"GetStatus", b"GetRobot", b"SetAdeptSpeed 5",
                  b"MoveMinChangeRowWiseStatus 0 0 -1 325 0 -1 0 -200 -1 0 0 200 flip toggleElbow toggleArm",
                  b"MoveMinChangeRowWiseStatus 1 0 0 500 0 1 0 10 0 0 1 200 flip toggleElbow toggleArm",
                  b"MoveMinChangeRowWiseStatus 0 0 -1 325 0 -1 0 -200 -1 0 0 700 flip toggleElbow toggleArm",
                  b"MoveMinChangeRowWiseStatus 0 0 -1 325 0 -1 0 200 -1 0 0 700 flip toggleElbow toggleArm",
                  b"MoveMinChangeRowWiseStatus 0 0 -1 325 0 -1 0 200 -1 0 0 200 flip toggleElbow toggleArm"]
                  #b"MoveMinChangeRowWiseStatus 1 0 0 925 0 1 0 800 0 0 1 50",
                  #b"MoveMinChangeRowWiseStatus 1 0 0 925 0 1 0 800 0 0 1 900",
                  #b"MoveMinChangeRowWiseStatus 1 0 0 925 0 1 0 -800 0 0 1 900",
                  #b"MoveMinChangeRowWiseStatus 1 0 0 925 0 1 0 -800 0 0 1 500"]  # x Ebene nahe uns
end_program = False

# Create a TCP/IP socket
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_address = ('localhost', 5005)
sock.connect(server_address)  # connect() only takes 1 argument

received_message = sock.recv(1024)
print(received_message.decode())
sock.sendall(b"Hello Robot")
received_message = sock.recv(1024)
print("Client: Hello Robot")
print("Server: ", received_message.decode())

for message in input_messages:
    sock.sendall(message)
    print("Client: ", message.decode())
    received_message = sock.recv(1024)
    print("Server: ", received_message.decode())