
from MultifunctionalDevice import MultifunctionalDevice

if __name__ == "__main__":
    device = MultifunctionalDevice(model="Multifunctional-Printer-2023", paper_count=200)

    device.print_document(10)
    device.scan_document()
    device.copy_document(5)
    device.add_paper(50)
    device.replace_toner()
    device.copy_document(15)
