package com.autotype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText edtMessages;
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtMessages = findViewById(R.id.edtMessages);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(v -> {
            String msg = edtMessages.getText().toString();
            if (msg.isEmpty()) {
                Toast.makeText(this, "Nhập nội dung!", Toast.LENGTH_SHORT).show();
                return;
            }
            AutoTypeService.messages = msg.split(",");
            AutoTypeService.running = true;
            Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivity(intent);
            Toast.makeText(this, "Bật AutoType trong Trợ năng!", Toast.LENGTH_LONG).show();
        });

        btnStop.setOnClickListener(v -> {
            AutoTypeService.running = false;
            Toast.makeText(this, "Đã dừng!", Toast.LENGTH_SHORT).show();
        });
    }
}
