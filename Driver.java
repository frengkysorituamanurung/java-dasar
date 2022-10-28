import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<User> allUsers = new ArrayList<>();
            ArrayList<Book> allBooks = new ArrayList<>();
            ArrayList<BookBorrowing> allBookBorrowings = new ArrayList<>();

            int totalLibrarian = 0, totalMember = 0;

            int totalUsers = Integer.parseInt(sc.nextLine());
            for (int i=1; i<=totalUsers; i++){
            
            String userRole = sc.nextLine();
      
            switch (userRole){
                case "Librarian":

                String  librarianname = sc. nextLine();
                String  librarianusername = sc. nextLine();
                String librarianpassword = sc.nextLine();

                Librarian newLibrarian = new Librarian();
                newLibrarian.setName(librarianname);
                newLibrarian.SetUsername(librarianusername);
                newLibrarian.SetPassword(librarianpassword);
            
                totalLibrarian++;
                allUsers.add(newLibrarian);

                break;
                case "Member":

                String  membername = sc. nextLine();
                        String  memberusername = sc. nextLine();
                        String memberpassword = sc.nextLine();

                        Member newMember = new Member();
                        newMember.setName(membername);
                        newMember.SetUsername(memberusername);
                        newMember.SetPassword(memberpassword);

                        allUsers.add(newMember);
                        totalMember++;

                        break;
            }
   
   }

   System.out.println(String.format("Jumlah pengguna sebagai pustakawan: %d", totalLibrarian));
   System.out.println(String.format("Jumlah pengguna sebagai anggota: %d", totalMember));
   

//check data login
   User datalogin = null;
   while (true){
            String loginUsername = sc.nextLine();

            if(loginUsername.equals ("Exit")) break;

            String loginPassword = sc.nextLine();
            for (User user: allUsers){
                if(user.login(loginUsername, loginPassword)){
                    datalogin = user;
                    break;
                }
            }

            if(datalogin==null){
                System.out.println("Kredensial akun tidak sesuai, silahkan mencoba kembali!");
            }
            else{

                System.out.println("Berhasil login, dengan informasi:");
                System.out.println(datalogin);

                while (true){
                    int mode = Integer.parseInt(sc.nextLine());
                    if(mode == 0) {
                        datalogin = null;
                        break;}

                    if(datalogin instanceof Librarian){

                        switch (mode){
                            case 1:
                                System.out.println("Melihat semua buku:");
                                for (Book b: allBooks){
                                    System.out.println(b);

                                }

                                break;

                            case 2:

                            System.out.println("Menambahkan buku baru:");
                            String bookTitle = sc.nextLine();
                            boolean existBook = false;
                            for(Book b: allBooks){
                                if (b.getTitle().equals(bookTitle)){
                                    existBook = true;
                                    break;
                                }
                            }

                            if(!existBook){
                                String bookAuthor = sc.nextLine();
                                String bookPublisher = sc.nextLine();

                                Book newBook = new Book();
                                newBook.setTitle(bookTitle);
                                newBook.setAuthor(bookAuthor);
                                newBook.setPublisher(bookPublisher);

                                allBooks.add(newBook);
                                System.out.println(String.format("Berhasil menambahkan buku \"%s\" baru.", bookTitle));
                            }else{
                                System.out.println(String.format("Judul buku \"%s\" telah tersedia, silahkan menambahkan buku lainnya.", bookTitle));
                            }

                            break;
                        }

                    }

                    else if(datalogin instanceof Member){

                        switch (mode){
                            case 1:
                                System.out.println("Melihat semua buku:");
                                for (Book b: allBooks){
                                    System.out.println(b);
                                }
                                break;

                            case 2:
                             System.out.println("Melihat semua buku yang dipinjam:");
                             for (BookBorrowing bb: allBookBorrowings){
                                if(bb.getMember() == datalogin){
                                    System.out.println(bb);
                                }
                            }
                                break;

                            case 3:

                                System.out.println("Meminjam buku:");
                                String bookTitle = sc.nextLine();
                                Book targetBook = null;
                                for(Book b: allBooks){
                                    if (b.getTitle().equals(bookTitle)){
                                        targetBook = b;
                                        break;  
                                    }
                                }

                                if (targetBook != null){
                                    
                                    String librarianName = sc.nextLine();
                                    Librarian targetLibrarian = null;
                                    for(User user: allUsers){
                                        if(user instanceof Librarian){
                                            if(user.getName().equals(librarianName)){
                                                targetLibrarian = (Librarian) user;
                                                break;
                                            }
                                        }
                                    }

                                    if(targetLibrarian != null){

                                        BookBorrowing bb = new BookBorrowing();
                                        bb.setBook(targetBook);
                                        bb.setLibrarian(targetLibrarian);
                                        bb.setMember((Member) datalogin);
                                        allBookBorrowings.add(bb);

                                        System.out.println(String.format("Berhasil melakukan peminjaman buku dengan judul \"%s\".", targetBook.getTitle()
                                        ));
 
                                    }else{
                                        System.out.println(String.format("Pustakawan dengan nama \"%s\" tidak ditemukan.", librarianName));
                                    }

                                }else{
                                    System.out.println(String.format("Judul buku \"%s\" belum tersedia!", bookTitle));
                                }

                                    break;

                                }
                             }
                        }
                    }
                }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         }
    }