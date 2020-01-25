package udit.programmer.co.ppi_con

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculate.*

class Calculate : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        bt01.setOnClickListener {
            operator("(")
        }

        bt02.setOnClickListener {
            operator(")")
        }

        bt10.setOnClickListener {
            num("7")
        }

        bt11.setOnClickListener {
            num("8")
        }

        bt12.setOnClickListener {
            num("9")
        }

        bt20.setOnClickListener {
            num("4")
        }

        bt21.setOnClickListener {
            num("5")
        }

        bt22.setOnClickListener {
            num("6")
        }

        bt30.setOnClickListener {
            num("1")
        }

        bt31.setOnClickListener {
            num("2")
        }

        bt32.setOnClickListener {
            num("3")
        }

        bt41.setOnClickListener {
            num("0")
        }

        bt03.setOnClickListener {
            operator("/")
        }

        bt13.setOnClickListener {
            operator("*")
        }

        bt23.setOnClickListener {
            operator("-")
        }

        bt33.setOnClickListener {
            operator("+")
        }

        bt00.setOnClickListener {
            allclear()
        }

        bt40.setOnClickListener {
            backspace()
        }

        bt42.setOnClickListener {
            operator(".")
        }

        val value = intent.getStringExtra("1")

        if (value.equals("a")) {
            bt43.setOnClickListener {
                postfix_to_infix()
                //equallogic(exp.text.toString(), Stackcar(), Stack())
            }
        } else if (value.equals("b")) {
            bt43.setOnClickListener {
                postfix_to_prefix()
            }
        } else if (value.equals("c")) {
            bt43.setOnClickListener {
                prefix_to_infix()
            }
        } else if (value.equals("d")) {
            bt43.setOnClickListener {
                prefix_to_postfix()
            }
        } else if (value.equals("e")) {
            bt43.setOnClickListener {
                infix_to_postfix()
            }
        } else if (value.equals("f")) {
            bt43.setOnClickListener {
                infix_to_prefix()
            }
        }

    }

    fun num(str: String) {

        if (res.text.isNotEmpty()) {
            exp.text = null
        }

        exp.append(str)
        res.text = ""

    }

    fun operator(str: String) {

        if (res.text.isNotEmpty()) {
            exp.setText("")
        }

        /* val abc: String = exp.text.substring(exp.length() - 1)

         if (abc.equals("+") || abc.equals("-") || abc.equals("*") || abc.equals("/")) {
             return
         } */
        exp.append(res.text)
        exp.append(str)
        res.setText("")
    }

    fun backspace() {

        var ans = exp.text.toString()

        if (ans.isNotEmpty()) {
            exp.setText(ans.substring(0, ans.length - 1))
        }

        res.setText("")
    }

    fun allclear() {

        exp.setText("")
        res.setText("")

    }

    fun postfix_to_infix(){
        

    }

    fun postfix_to_prefix(){

    }

    fun prefix_to_infix(){

    }

    fun prefix_to_postfix(){

    }

    fun infix_to_postfix(){

    }

    fun infix_to_prefix(){

    }
}
