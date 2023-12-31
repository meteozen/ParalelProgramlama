package com.example.javatutorials.finalhome.parallelprogramming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**ÖDEV
 *
 Paralel programlama için Java ile uygulama yapılacaktır. İstenen özellikler aşağıda gösterilmiştir.
        Step-1 ) Yapılacak uygulama kullanıcıda(user) iki tane farklı veri console üzerinden bilgi alınacaktır. Ancak
 alınacak veriler belli sırada olması gerekmektedir önce birinci thread çalışacak işlem bittikten sonra ikinci
 thread çalışacaktır. Bunuda Java Paralel programlama özelliğiyle yapılması gerekiyor. Örneğin: 1.thread
 çalışacak ve sonrasında 2.thread çalışacaktır. (Thread Join özelliğiyle)
        Step-2 ) Birinci thread Kulanıcı bilgileri console üzerindenn Scanner nesnesi üzerinden alınacak
 username,password ve email adres bunu file bilgisayarın c:\\io\\turgutozaluniversitesi\\person.txt dosyasına
 kaydedilecektir.
        Step-3 ) İkinci thread çalışacak kullanıcının secretInformation(tanımlama) isterseniz database kaydedin
 isterseniz c:\\io\\turgutozaluniversitesi\\secret.txt  adındaki dosyaya kaydedin.

 */
public class ParallelService extends Thread{
    public static final String PERSON_URL;

    static {
        PERSON_URL = "c:\\io\\turgutozaluniversitesi\\person.txt";
    }

    public static final String SECRET_URL;

    static {
        SECRET_URL = "c:\\io\\turgutozaluniversitesi\\secret.txt";
    }

    /////////////////////////////////////////////////////////////////
    ///////////////////////////DATA1/////////////////////////////////
    /////////////////////////////////////////////////////////////////

    public String userDataInformation() {

        Scanner klavye = new Scanner(System.in);
        String username, password, email;
        System.out.println("Username giriniz \n");
        username = klavye.nextLine();
        System.out.println("Password giriniz \n");
        password = klavye.nextLine();
        System.out.println("email giriniz ");
        email = klavye.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(username).append(password).append(email);
        return stringBuilder.toString();
    }

    public void fileIouserDataInformation() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PERSON_URL, false))) {
            String userData = userDataInformation();
            bufferedWriter.write(userData);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /////////////////////////////////////////////////////////////////
    ///////////////////////////DATA2/////////////////////////////////
    /////////////////////////////////////////////////////////////////

    public String userDataSecretInformation() {
        Scanner klavye = new Scanner(System.in);
        String secretInformation;
        System.out.println("secretInformation giriniz");
        secretInformation = klavye.nextLine();
        return secretInformation;
    }

    public void fileIouserSecretInformation() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(SECRET_URL, false))) {
            String userData = userDataSecretInformation();
            bufferedWriter.write(userData);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    ///////////////////////////////////////////////////////////////
    //////////////////////MULTITHREAD//////////////////////////////
    ///////////////////////////////////////////////////////////////
    */

    public static void main(String[] args) throws InterruptedException {

        ///////////////////THREAD1/////////////////////////////////

        ParallelService parallelService1=new ParallelService();
        parallelService1.fileIouserDataInformation();// fileIouserDataInformation


        ///////////////////THREAD2/////////////////////////////////

        ParallelService parallelService2=new ParallelService();
        parallelService2.fileIouserSecretInformation();// fileIouserSecretInformation

        parallelService1.start();
        parallelService1.join();

        parallelService2.start();
        parallelService2.join();
    }

}