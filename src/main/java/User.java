import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private String customer_mail_address;
    private String user_name;
    private String password;
    private String first_name;
    private String last_name;
    private String payment_method;
    private String payment_card_number;
    private String contract_type;
    private String subscription_start;
    private String subscription_end;
    private String country_name;
    private String gender;
    private String birth_date;

    /*username is user crediental*/

    public User(String username,String password) throws SQLException {

        getUserData(username,password);

    }

    private User getUserData(String username, String password) throws SQLException {
        ConnectDB connectDB = new ConnectDB();
        String query = "SELECT * FROM dbo.Customer WHERE user_name = ? AND password = ? OR customer_mail_address = ? AND password = ?";
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,username);
        preparedStatement.setString(4,password);



        ResultSet resultSet = preparedStatement.executeQuery();

        User user = null;
        while (resultSet.next()) {
            user_name = resultSet.getString("user_name");
            first_name = resultSet.getString("first_name");
            last_name = resultSet.getString("last_name");
            customer_mail_address = resultSet.getString("customer_mail_address");
            payment_method = resultSet.getString("payment_method");
            payment_card_number = resultSet.getString("payment_card_number");
            contract_type = resultSet.getString("contract_type");
            subscription_start = resultSet.getString("subscription_start");
            subscription_end = resultSet.getString("subscription_end");
            country_name = resultSet.getString("country_name");
            gender = resultSet.getString("gender");
            birth_date = resultSet.getString("birth_date");
            user = new User(customer_mail_address,user_name,password,first_name,last_name,payment_method,payment_card_number,contract_type,subscription_start,subscription_end,country_name,gender,birth_date);

        }
        return user;
    }

    private User(String customer_mail_address,String user_name,String password,String first_name,String last_name,String payment_method,String payment_card_number,String contract_type,String subscription_start,String subscription_end,String country_name,String gender,String birthdate){
        this.customer_mail_address=customer_mail_address;
        this.user_name=user_name;
        this.password=password;
        this.first_name=first_name;
        this.last_name=last_name;
        this.payment_method=payment_method;
        this.payment_card_number=payment_card_number;
        this.contract_type=contract_type;
        this.subscription_start=subscription_start;
        this.subscription_end=subscription_end;
        this.country_name=country_name;
        this.gender=gender;
        this.birth_date=birth_date;
    }

    public String getCustomer_mail_address() {
        return customer_mail_address;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public String getPayment_card_number() {
        return payment_card_number;
    }

    public String getContract_type() {
        return contract_type;
    }

    public String getSubscription_start() {
        return subscription_start;
    }

    public String getSubscription_end() {
        return subscription_end;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirth_date() {
        return birth_date;
    }



}
