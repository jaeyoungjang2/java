import java.util.Scanner;

public class ExceptionEx4 {
    static final String userId = "1234";
    static final String userPasswd = "1234pw";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("id 를 입력하세요");
            String id = sc.nextLine();
            System.out.println("password 를 입력하세요");
            String passwd = sc.nextLine();
            if (!userId.equals(id)) {
                throw new LoginException("id가 일치하지 않습니다.");
            } else if (!userPasswd.equals(passwd)) {
                throw new LoginException("passwd가 일치하지 않습니다.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());

        }

    }

}
