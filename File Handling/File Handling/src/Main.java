import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("File Handling");
        Scanner scan = new Scanner(System.in);
        int n = 1;
        do{
            System.out.println("--------- Select operation ---------");
            System.out.println("" +
                    "\n1. Create a file " +
                    "\n2. Get File Info " +
                    "\n3. Get word count" +
                    "\n4. Get Character count" +
                    "\n5. Write contents in the File" +
                    "\n6. Reads Contents from the file" +
                    "\n7. Delete a file" +
                    "\n8. Check the no. of occurrences of a word in a file");
            System.out.println("Enter your choice: ");
            n = scan.nextInt();
            switch(n){
                case 1:
                    //creating a file
                    System.out.println("Creating a file.....");
                    System.out.println("Enter the file name: ");
                    String fileName = scan.next();
                    try{
                        //creating file object
                        File f = new File(fileName);
                        if(f.createNewFile()){
                            System.out.println("File " + fileName + " created successfully :)");
                        }else{
                            System.out.println("A file with the name " + fileName + " already exist in the directory!");
                        }
                    }catch(Exception e){
                        System.out.println("An unexpected error occurred! :(");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    //Getting file info
                    System.out.println("Enter the file Name: ");
                    String filename = scan.next();
                    System.out.println("Counting words in the file.....");
                    File f = new File(filename);
                    if(f.exists()){
                        //getting file name
                        System.out.println("File name: " + f.getName());
                        //getting file path
                        System.out.println("File path: " + f.getPath());
                        //checking file permissions
                        System.out.println("Is file writeable? " + f.canWrite());
                        System.out.println("Is file readable? " + f.canRead());
                        //getting file space
                        System.out.println("File space: "+ f.getTotalSpace());
                    }else{
                        System.out.println("The file doesn't exist!") ;
                    }
                    break;
                case 3:
                    //word count
                    System.out.println("Enter the file Name: ");
                    fileName = scan.next();
                    System.out.println("Counting words in the file.....");
                    File f0 = new File(fileName);
                    if(f0.exists()){
                        int words = 0;
                        String line;
                        FileReader file = new FileReader(f0);
                        BufferedReader br = new BufferedReader(file);
                        while((line = br.readLine()) != null) {
                            String array[] = line.split(" ");
                            words = words + array.length;
                        }
                        System.out.println("Word count: " + words);
                        br.close();
                    }else{
                        System.out.println("The file doesn't exist!");
                    }
                    break;
                case 4:
                    //get character count
                    System.out.println("Enter the file Name: ");
                    fileName = scan.next();
                    System.out.println("Counting characters in the file.....");
                    File f1 = new File(fileName);
                    if(f1.exists()){
                        int characters = 0;
                        String line;
                        FileReader file = new FileReader(f1);
                        BufferedReader br = new BufferedReader(file);
                        while((line = br.readLine()) != null) {
                            String array = line.strip().replaceAll("\\s","");
                            characters = characters + array.length();
                        }
                        System.out.println("Character count: " + characters);
                        br.close();
                    }else{
                        System.out.println("The file doesn't exist!");
                    }
                    break;
                case 5:
                    //writing in  a file
                    System.out.println("Enter the file Name: ");
                    fileName = scan.next();
                    File f2 = new File(fileName);
                    if(f2.exists()){
                        FileWriter fileWriter = new FileWriter(fileName);
                        System.out.println("Enter the contents you want to write in the file: ");
                        String content = scan.nextLine();
                        content = scan.nextLine();
                        fileWriter.write(content);
                        fileWriter.close();
                        System.out.println("Contents wrote successfully....");
                    }else{
                        System.out.println("The file doesn't exist!");
                    }
                    break;
                case 6:
                    //reading from a file
                    System.out.println("Enter the file Name: ");
                    fileName = scan.next();
                    System.out.println("Reading from file..... \n");
                    File f3 = new File(fileName);
                    if(f3.exists()){
                        Scanner dataReader = new Scanner(f3);
                        while (dataReader.hasNextLine()) {
                            String fileData = dataReader.nextLine();
                            System.out.println(fileData);
                        }
                        dataReader.close();
                    }else{
                        System.out.println("The file doesn't exist!");
                    }
                    break;
                case 7:
                    System.out.println("Enter the file Name: ");
                    fileName = scan.next();
                    File f4 = new File(fileName);
                    if (f4.delete()) {
                        System.out.println(f4.getName()+ " file is deleted successfully.");
                    } else {
                        System.out.println("Unexpected error found in deletion of the file.");
                    }
                    break;
                case 8:
                    System.out.println("Enter the file Name: ");
                    fileName = scan.next();
                    System.out.println("Reading from file..... \n");
                    File f5 = new File(fileName);
                    if(f5.exists()){
                        int occurence = 0;
                        String line;
                        FileReader file = new FileReader(f5);
                        BufferedReader br = new BufferedReader(file);
                        System.out.println("Enter the word: ");
                        String word = scan.next();
                        while((line = br.readLine()) != null) {
                            String array[] = line.split(" ");
                            for(int i=0; i<array.length; i++){
                                if(array[i].equals(word)){
                                    occurence +=1;
                                }
                            }
                        }
                        System.out.println("Occurrence of word "+ word + ": " + occurence);
                        br.close();
                    }else{
                        System.out.println("The file doesn't exist!");
                    }
                    break;
                default:
                    System.out.println("Invalid operation");
            }
            System.out.println("-------------------------------------------");
            System.out.println("Do you wish to continue? 0.Exit 1.Continue");
            n = scan.nextInt();
        }while(n!=0);
        System.out.println("Thank you.... :)");
    }
}

//--------------------------------
/*
* Output:
* "C:\Program Files\Java\jdk-19\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.1\lib\idea_rt.jar=55301:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.1\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\CCOEW\IdeaProjects\File Handling\out\production\File Handling" Main
File Handling
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
1
Creating a file.....
Enter the file name:
file
A file with the name file already exist in the directory!
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
6
Enter the file Name:
file
Reading from file.....

This is new line
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
1
Creating a file.....
Enter the file name:
file1
File file1 created successfully :)
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
2
Enter the file Name:
file
Counting words in the file.....
File name: file
File path: file
Is file writeable? true
Is file readable? true
File space: 313985650688
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
2
Enter the file Name:
file1
Counting words in the file.....
File name: file1
File path: file1
Is file writeable? true
Is file readable? true
File space: 313985650688
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
3
Enter the file Name:
file1
Counting words in the file.....
Word count: 0
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
5
Enter the file Name:
file1
Enter the contents you want to write in the file:
this is a new file and first lab of cloud computing
Contents wrote successfully....
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
6
Enter the file Name:
file1
Reading from file.....

this is a new file and first lab of cloud computing
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
3
Enter the file Name:
file1
Counting words in the file.....
Word count: 11
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
4
Enter the file Name:
file1
Counting characters in the file.....
Character count: 41
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
8
Enter the file Name:
file1
Reading from file.....

Enter the word:
cloud
Occurrence of word cloud: 1
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
8
Enter the file Name:
file1
Reading from file.....

Enter the word:
is
Occurrence of word is: 1
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
8
Enter the file Name:
file1
Reading from file.....

Enter the word:
null
Occurrence of word null: 0
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
7
Enter the file Name:
file1
file1 file is deleted successfully.
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
1
--------- Select operation ---------

1. Create a file
2. Get File Info
3. Get word count
4. Get Character count
5. Write contents in the File
6. Reads Contents from the file
7. Delete a file
8. Check the no. of occurrences of a word in a file
Enter your choice:
2
Enter the file Name:
file1
Counting words in the file.....
The file doesn't exist!
-------------------------------------------
Do you wish to continue? 0.Exit 1.Continue
0
Thank you.... :)

Process finished with exit code 0
*/