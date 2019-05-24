from tkinter import *
from tkinter.font import Font

class Window(Frame):
    def __init__(self, master = None):
        Frame.__init__(self,master)
        myfont = Font(family="Ubuntu Mono", size=14)
        self.master = master
        self.price = 0
        self.grid()
        self.master.title("SPA")
        self.master.grid_rowconfigure(0, weight=1)
        self.master.grid_columnconfigure(0, weight=1)

        self.master.configure()
        frame = Frame(self.master)
        frame.configure(bg='bisque')
        frame.grid( row=0, column=0, sticky="nsew")

        for r in range(5):
            frame.rowconfigure(r, weight=1)

        label = Label(frame, text="Dharma Day Spa",bg = 'mint cream', font=('Ubuntu Mono', '18')).grid(row=0, column=0,padx=50)
        self.val= IntVar()
        radio1 = Radiobutton(frame,text="Manicure $15",bg = 'mint cream',font=myfont, variable = self.val, value = 15).grid(row=1,padx=50,
                                                                                                          column = 0,sticky=W)
        radio2 = Radiobutton(frame, text="Pedicure $18",bg = 'mint cream',font=myfont, variable=self.val, value=18).grid(row=2, column=0,padx=50
                                                                                                       ,sticky=W)
        radio3 = Radiobutton(frame, text="Both $30",bg = 'mint cream',font=myfont, variable=self.val, value=30).grid(row=3, column=0,padx=50
                                                                                                   ,sticky=W)
        button = Button(frame,text = "Order now",font=myfont,bg = 'lemon chiffon', command = self.click).grid(row=4, column=0,sticky=W,padx=50)


    def click(self):
        print("Clicked!!")
        popup = Tk()
        popup.geometry("200x100")
        popup.title("Price")
        label = Label(popup, font=("Arial Bold", 10), text="Price of your order: \n\n $" + str(self.val.get()))
        label.pack(side="top", fill="x", pady=10)
        B1 = Button(popup, text="Exit", command=popup.destroy)
        B1.pack()
        popup.mainloop()

root = Tk()
root.geometry("300x300")
app = Window(master=root)
app.mainloop()