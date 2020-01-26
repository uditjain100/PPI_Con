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
                postfix_to_infix(exp.text.toString(), Stack())
            }
        } else if (value.equals("b")) {
            bt43.setOnClickListener {
                postfix_to_prefix(exp.text.toString(), Stack())
            }
        } else if (value.equals("c")) {
            bt43.setOnClickListener {
                prefix_to_infix(exp.text.toString(), Stack())
            }
        } else if (value.equals("d")) {
            bt43.setOnClickListener {
                prefix_to_postfix(exp.text.toString(), Stack())
            }
        } else if (value.equals("e")) {
            bt43.setOnClickListener {
                infix_to_postfix(exp.text.toString(), Stack())
            }
        } else if (value.equals("f")) {
            bt43.setOnClickListener {
                infix_to_prefix(exp.text.toString(), Stack())
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

    fun postfix_to_infix(exp: String, stack: Stack) {

    }

    fun postfix_to_prefix(exp: String, stack: Stack) {

    }

    fun prefix_to_infix(exp: String, stack: Stack) {

    }

    fun prefix_to_postfix(exp: String, stack: Stack) {

    }

    fun infix_to_postfix(exp: String, stack: Stack) {

        var ans = ""
        var temp = 0
        for (i in 0..exp.length - 1) {

            val ch = exp.elementAt(i)
            if (ch >= '0' && ch <= '9') {
                ans += exp.substring(i, i + 1)
            } else if (ch == '(') {
                stack.push(ch.toInt())
            } else if (ch == ')') {
                while (stack.top() !== '('.toInt()) {
                    val rv = stack.pop()
                    ans += cts(rv.toChar())
                }
            } else {
                if (temp == 0) {
                    stack.push(ch.toInt())
                    temp = 1
                } else {
                    if (stack.top() === 40) {
                        stack.push(ch.toInt())
                    } else if (stack.top().toInt() < ch.toInt()) {
                        stack.push(ch.toInt())
                    } else if (stack.top() as Int >= ch.toInt()) {
                        while (stack.isEmpty || stack.top().toInt() < ch.toInt()) {
                            val rv = stack.pop()
                            print(rv)
                            ans += cts(rv.toChar())
                        }
                        stack.push(ch.toInt())
                    }
                }
            }

        }
        while (!stack.isEmpty) {
            val rv = stack.pop()
            if (rv != 40) {
                ans += cts(rv.toChar())
            }
        }

        res.setText(ans)

    }

    fun infix_to_prefix(exp2: String, stack: Stack) {

        var exp = exp2.reversed()

        var ans = ""
        var temp = 0
        for (i in 0..exp.length - 1) {

            val ch = exp.elementAt(i)
            if (ch >= '0' && ch <= '9') {
                ans += exp.substring(i, i + 1)
            } else if (ch == '(') {
                stack.push(ch.toInt())
            } else if (ch == ')') {
                while (stack.top() !== '('.toInt()) {
                    val rv = stack.pop()
                    ans += cts(rv.toChar())
                }
            } else {
                if (temp == 0) {
                    stack.push(ch.toInt())
                    temp = 1
                } else {
                    if (stack.top() === 40) {
                        stack.push(ch.toInt())
                    } else if (stack.top().toInt() < ch.toInt()) {
                        stack.push(ch.toInt())
                    } else if (stack.top() as Int >= ch.toInt()) {
                        while (stack.isEmpty || stack.top().toInt() < ch.toInt()) {
                            val rv = stack.pop()
                            print(rv)
                            ans += cts(rv.toChar())
                        }
                        stack.push(ch.toInt())
                    }
                }
            }

        }
        while (!stack.isEmpty) {
            val rv = stack.pop()
            if (rv != 40) {
                ans += cts(rv.toChar())
            }
        }

        var ans2 = ans.reversed()

        res.setText(ans2)

    }

    fun Prec(ch: Char): Int {
        if (ch == '+' || ch == '-') {
            return 1
        } else if (ch == '*' || ch == '/') {
            return 2
        } else if (ch == '^') {
            return 3
        } else {
            return -1
        }
    }

    fun cti(c: Char): Int {

        if (c == '0') {
            return 0
        } else if (c == '1') {
            return 1
        } else if (c == '2') {
            return 2
        } else if (c == '3') {
            return 3
        } else if (c == '4') {
            return 4
        } else if (c == '5') {
            return 5
        } else if (c == '6') {
            return 6
        } else if (c == '7') {
            return 7
        } else if (c == '8') {
            return 8
        } else {
            return 9
        }
    }

    fun cts(ch: Char): String {
        if (ch == '+') {
            return "+";
        } else if (ch == '-') {
            return "-";
        } else if (ch == '*') {
            return "*";
        } else if (ch == '/') {
            return "/";
        } else if (ch == '(') {
            return "(";
        } else if (ch == ')') {
            return ")";
        } else if (ch == '^') {
            return "^";
        } else if (ch == '1') {
            return "1";
        } else if (ch == '2') {
            return "2";
        } else if (ch == '3') {
            return "3";
        } else if (ch == '4') {
            return "4";
        } else if (ch == '5') {
            return "5";
        } else if (ch == '6') {
            return "6";
        } else if (ch == '7') {
            return "7";
        } else if (ch == '8') {
            return "8";
        } else if (ch == '9') {
            return "9";
        } else if (ch == '0') {
            return "0";
        }

        return "";
    }
}
