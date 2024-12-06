
from Printer import Printer

class MultifunctionalDevice(Printer):
    def __init__(self, model, paper_count=100, toner_level=100):
        super().__init__(model, paper_count)
        self._toner_level = toner_level

    def scan_document(self):
        print("Scanning document...")

    def copy_document(self, pages):
        if pages <= self._paper_count:
            if self._toner_level >= pages:
                self._paper_count -= pages
                self._toner_level -= pages
                print(f"Copied {pages} pages. Remaining paper: {self._paper_count}, toner level: {self._toner_level}.")
            else:
                print("Not enough toner to copy the document.")
        else:
            print("Not enough paper to copy the document.")

    def replace_toner(self):
        self._toner_level = 100
        print("Toner replaced. Toner level is now 100.")
