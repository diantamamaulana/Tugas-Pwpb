package space.diantama.pendaftaran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText eNama;
    private EditText eAsal;
    private EditText eAlamat;

    private Button bCetak;
    private TextView tHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNama = findViewById(R.id.nama);
        eAsal = findViewById(R.id.asalsekolah);
        eAlamat = findViewById(R.id.alamat);
        bCetak = findViewById(R.id.bcetak);
        tHasil = findViewById(R.id.hasil);

        bCetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nama = eNama.getText().toString().trim();
                String asalSekolah = eAsal.getText().toString().trim();
                String alamat = eAlamat.getText().toString().trim();

                boolean isEmpetyFields = false;


                if (nama.isEmpty()) {
                    isEmpetyFields = true;
                    eNama.setError("Tidak Boleh Kosong");
                }if (asalSekolah.isEmpty()) {
                    isEmpetyFields = true;
                    eAsal.setError("Tidak Boleh Kosong");
                }if (alamat.isEmpty()) {
                    isEmpetyFields = true;
                    eAlamat.setError("Rumah lu disurga?");
                }

                if (status(nama, asalSekolah, alamat)) {
                    tHasil.setText("Bye banget!");
                } else {
                    tHasil.setText(String.format("%s\n%s\n%s", nama, asalSekolah, alamat));
                }


            }
        });
    }

    private boolean status(String nama, String asal, String alamat) {
        return nama.isEmpty() && asal.isEmpty() && alamat.isEmpty();
    }
}
