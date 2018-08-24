package br.com.murilo.ecommercepucapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EmployeeMenuActivity extends AppCompatActivity {

    private Button customerManagementButton;
    private Button productManagementButton;
    private Button productCategoryManagementButton;
    private Button orderReportButton;
    private Button stockReportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_employee_menu);
        this.initialize();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, LoginActivity.class);
        this.startActivity(intent);
    }

    private void initialize() {
        this.customerManagementButton = findViewById(R.id.employeeMenuCustomerEnrollmentButton);
        this.productManagementButton = findViewById(R.id.employeeMenuProductEnrollmentButton);
        this.productCategoryManagementButton = findViewById(R.id.employeeMenuProductCategoryEnrollmentButton);
        this.orderReportButton = findViewById(R.id.employeeMenuOrderReportButton);
        this.stockReportButton = findViewById(R.id.employeeMenuStockReportButton);

        this.customerManagementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmployeeMenuActivity.this, CustomerManagementActivity.class);
                startActivity(intent);
            }
        });

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(EmployeeMenuActivity.this, "Recurso indisponível", Toast.LENGTH_LONG);
                toast.show();
            }
        };

        this.productManagementButton.setOnClickListener(onClickListener);
        this.productCategoryManagementButton.setOnClickListener(onClickListener);
        this.orderReportButton.setOnClickListener(onClickListener);
        this.stockReportButton.setOnClickListener(onClickListener);
    }
}
