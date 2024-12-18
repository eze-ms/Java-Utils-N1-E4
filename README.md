# Directory Tree 📂

## 📄 Description
This Java project lists the content of a directory tree starting from a given directory. It provides a detailed recursive exploration of all subdirectories and files, showing their type and last modified date.

### **Functionality**
Core Features:
- Displays a directory tree starting from a specified path.
- Lists:
    - **[D]** for directories.
    - **[F]** for files.
- Shows the last modified date for each item.
- Recursively lists content in alphabetical order within each level.

Robust Design:
- Modular structure:
    - `Utils.java` handles validations and formatting.
    - `DirectoryLister.java` handles the directory listing logic.
- Works seamlessly with or without command-line arguments.

---

## 💻 Technologies Used
- Java 17
- IntelliJ IDEA as the development environment

---

## 📋 Requirements
- Java Development Kit (JDK): Version 17 or higher.
- IDE: IntelliJ IDEA or any Java-compatible IDE.

---

## 🚀 Execution
1. Compile the project:
   ```bash
   javac -d out Main.java DirectoryLister.java auxiliar/Utils.java

2. Run the program, providing the path to a directory or a TXT file as an argument:
   ```bash
   java -cp out Main /path/to/directory_or_file

3. If a directory path is provided, the output will be saved in a `directory_list.txt` file inside the current working directory.

4. If a TXT file path is provided, the content of the file will be displayed directly in the console.

### Without Arguments:
1. Run the program without arguments, and it will prompt you for a directory path or a TXT file path:
   ```bash
   java -cp out Main

2. Enter the full path to a directory or a TXT file. If it is a directory, the listing will be saved in a `directory_list.txt` file. If it is a TXT file, its content will be displayed in the console.



### Example Output:
#### Output in macOS (as tested):
1. When providing the path to a directory, the program generates a file named `directory_list.txt` with the following structure:
- [D] SubFolder (Last Modified: 16-12-2024 11:04:51)
    - [F] file1.txt (Last Modified: 12-12-2024 21:00:10)
    - [F] file2.txt (Last Modified: 12-12-2024 21:00:10)

2. When providing the path to a TXT file (`sample.txt`), the program outputs:
   This is the first line of the test file.
   This is the second line of the test file.

   
#### Equivalent output in Windows:
1. When providing the path to a directory, the program generates:
- [D] C:\Temp\SubFolder (Last Modified: 12-12-2024 10:30:45)
  - [F] C:\Temp\SubFolder\File1.txt (Last Modified: 12-12-2024 10:30:45)
  - [F] C:\Temp\SubFolder\File2.txt (Last Modified: 12-12-2024 10:30:45)

2. When providing the path to a TXT file (`sample.txt`), the program outputs:
   This is the first line of the test file.
   This is the second line of the test file.

---

## 🛠️ Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/eze-ms/Java-Utils-N1-E4.git
