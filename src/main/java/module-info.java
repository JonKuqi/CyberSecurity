module com.example.doublecolumnar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.doublecolumnar to javafx.fxml;
    opens DoubleColumnarTransposition to javafx.graphics;
    //exports com.example.doublecolumnar;
}