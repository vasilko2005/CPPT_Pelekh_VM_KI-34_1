
class Printer:
    def __init__(self, model, paper_count=100):
        self._model = model
        self._paper_count = paper_count

    def print_document(self, pages):
        if pages <= self._paper_count:
            self._paper_count -= pages
            print(f"Printed {pages} pages. Remaining paper: {self._paper_count}.")
        else:
            print("Not enough paper to print the document.")

    def add_paper(self, sheets):
        self._paper_count += sheets
        print(f"Added {sheets} sheets. Total paper: {self._paper_count}.")

    def get_model(self):
        return self._model
