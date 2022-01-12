from tkinter import *
import socket


class Gui:
    def __init__(self):
        self.command = None
        self.connected = False
        self.sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.window = Tk()
        self.window.title('FollowMe')
        self.window.geometry("500x500")

        self.text = Text(self.window, height=50)
        self.text.place(x=20, y=150)


        self.serverbutton = Button(self.window, text="Connect to RobServer", fg='blue')
        self.serverbutton.place(x=20, y=20)
        self.serverbutton.bind('<Button-1>', self.connect_to_robserver)

        self.button1 = Button(self.window, text="Test Boundaries Drive", fg='green')
        self.button1.place(x=20, y=50)
        self.button1.bind('<Button-1>', self.test_boundaries_drive)

        self.button2 = Button(self.window, text="Zero Position")
        self.button2.place(x=150, y=40)

        self.label = Label(text="Enter command here:")
        self.label.place(x=20, y=100)
        self.textfield = Entry(self.window, bd=5)
        self.textfield.place(x=20, y=120)
        self.textfield.bind('<Return>', self.enter_command)

        self.window.mainloop()

    def test_boundaries_drive(self, event):
        print("test")
        button = Button(self.window, text="la")
        button.place(x=100, y=100)


    def connect_to_robserver(self, event):

        server_address = ('localhost', 5005)
        try:
            self.sock.connect(server_address)  # connect() only takes 1 argument
            received_message = self.sock.recv(1024)
            self.text.insert(END, received_message.decode(), "\n")
            self.sock.sendall(b"Hello Robot")
            received_message = self.sock.recv(1024)
            output = "Hello Robot: " + received_message.decode() + "\n"
            self.text.insert(END, ''.join(output))
            self.connected = True
        except ConnectionError:
            self.text.insert(END, "Connection Error. Please try again.\n")

    def enter_command(self, event):
        if self.connected:
            self.command = self.textfield.get()
            self.sock.sendall(self.command.encode())
            received_message = self.sock.recv(1024)
            output = self.command + ": ", received_message.decode() + "\n"
            self.text.insert(END, ''.join(output))
            if self.command == "Quit":
                self.connected = False
        else:
            self.text.insert(END, "Connect to server first.\n")