from tkinter import *

class Window(Frame):
    def __init__(self, master = None):
        Frame.__init__(self,master)
        self.master = master
        self.price = 0
        self.grid()
        self.init_window()

    def init_window(self):
        self.master.title("Sanderson’s Ice Cream Sundaes")

        for r in range(6):
            self.master.rowconfigure(r, weight=1)
        for c in range(5):
            self.master.columnconfigure(c, weight=1)

        frame1 = Frame(self.master)
        frame1.grid(row=0, column=0, rowspan=3, columnspan=2, sticky=W + E + N + S)
        for r in range(5):
            frame1.rowconfigure(r, weight=1)


        label = Label(frame1, text = "Sanderson’s Ice Cream Sundaes", font = ("Arial Bold",10))
        label.grid(row=0, column=0,sticky=W,padx=60)
        optionLabel = Label(frame1, text="Option")
        optionLabel.grid(row=1, column=0,sticky=W,padx=100)
        self.optionVal = IntVar()
        self.optionVal.set(12.2)
        self.price = 12.2
        radio1 = Radiobutton(frame1,text = "One-scoop $12.2",variable=self.optionVal,
                             value=12.2,command=self.selectOption).grid(row=2, column=0,sticky=W,padx=100)
        radio2 = Radiobutton(frame1,text = "Two-scoop $23",variable=self.optionVal,
                             value=23,command=self.selectOption).grid(row=3, column=0,sticky=W,padx=100)
        radio3 = Radiobutton(frame1,text = "Three-scoop $24",variable=self.optionVal,
                             value=24,command=self.selectOption).grid(row=4, column=0,sticky=W,padx=100)

        frame2 = Frame(self.master)
        frame2.grid(row = 3, column = 0, rowspan = 3, columnspan = 2, sticky = W+E+N+S)
        for r in range(4):
            frame2.rowconfigure(r, weight=1)
        #optionVal = IntVar()
        flavorLabel = Label(frame2, text="Toppings $1.5").grid(row=0, column=0,sticky=W,padx=100)
        self.topping1 = IntVar()
        self.topping2 = IntVar()
        self.topping3 = IntVar()
        checkTopping1 = Checkbutton(frame2,  text="Nuts", variable = self.topping1 ).grid(row=1, column=0,sticky=W,padx=100)
        checkTopping2 = Checkbutton(frame2,  text="Whipped Cream", variable = self.topping2 ).grid(row=2, column=0,sticky=W,padx=100)
        checkTopping3 = Checkbutton(frame2,  text="Cherries", variable = self.topping3).grid(row=3, column=0,sticky=W,padx=100)

        frame3 = Frame(self.master)
        frame3.grid(row = 0, column = 2, rowspan = 6, columnspan = 3, sticky = W+E+N+S)
        for r in range(10):
            frame3.rowconfigure(r, weight=1)
        flavorLabel = Label(frame3,text="Flavor").grid(row=0, column=0, sticky=W,padx=60)
        self.flavor = IntVar()
        self.flavor.set(1)
        check1 = Radiobutton(frame3,text = "Chocolate", variable=self.flavor, value =1).grid(row=1, column=0,sticky=W,padx=60)
        check2 = Radiobutton(frame3,text = "Strawberry",variable=self.flavor, value =2).grid(row=2, column=0,sticky=W,padx=60)
        check3 = Radiobutton(frame3,text = "Vanilla",variable=self.flavor, value =3).grid(row=3, column=0,sticky=W,padx=60)
        orderButton = Button(frame3, text = "Order Now", command=self.orderFinished)
        orderButton.grid(row=6, column=0,sticky=W,padx=60)

    def orderFinished(self):
        print("Clicked!!")
        popup = Tk()
        popup.geometry("200x100")
        popup.title("Price")
        if self.topping1.get():
            self.price += 1.5
        if self.topping2.get():
            self.price += 1.5
        if self.topping3.get():
            self.price += 1.5

        label = Label(popup,font = ("Arial Bold",10), text="Price of your order: \n\n $" + str(self.price))
        label.pack(side="top", fill="x", pady=10)
        B1 = Button(popup, text="Exit", command=popup.destroy)
        B1.pack()
        popup.mainloop()

    def selectOption(self):
        print("selected an option")
        print("val ", str(self.optionVal.get()))
        self.price = self.optionVal.get()


root = Tk()
root.geometry("600x300+200+200")
app = Window(master=root)
app.mainloop()