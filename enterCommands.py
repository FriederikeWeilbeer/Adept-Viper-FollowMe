import socket

input_messages = [b"Hello Robot", b"GetStatus", b"GetRobot"]
end_program = False

# Create a TCP/IP socket
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_address = ('localhost', 5005)
sock.connect(server_address)  # connect() only takes 1 argument

received_message = sock.recv(1024)
print(received_message.decode())
sock.sendall(b"Hello Robot")
received_message = sock.recv(1024)
print("Hello Robot: ", received_message.decode())

while not end_program:
    command = input("Enter your command: ")
    sock.sendall(command.encode())
    received_message = sock.recv(1024)
    print(command, ": ", received_message.decode())
    if command == "Quit":
        end_program = True
