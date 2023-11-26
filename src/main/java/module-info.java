module com.example.quizapp_javafx {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.quizapp_javafx to javafx.fxml;
    exports com.example.quizapp_javafx;
}