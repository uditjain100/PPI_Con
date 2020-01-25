package udit.programmer.co.ppi_con

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_1.setOnClickListener {
            startActivity(Intent(this, Calculate::class.java).putExtra("1", "a"))
        }

        btn_2.setOnClickListener {
            startActivity(Intent(this, Calculate::class.java).putExtra("1", "b"))
        }

        btn_3.setOnClickListener {
            startActivity(Intent(this, Calculate::class.java).putExtra("1", "c"))
        }

        btn_4.setOnClickListener {
            startActivity(Intent(this, Calculate::class.java).putExtra("1", "d"))
        }

        btn_5.setOnClickListener {
            startActivity(Intent(this, Calculate::class.java).putExtra("1", "e"))
        }

        btn_6.setOnClickListener {
            startActivity(Intent(this, Calculate::class.java).putExtra("1", "f"))
        }
    }
}
