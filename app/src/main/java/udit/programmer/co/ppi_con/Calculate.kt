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
                var ans: String = postfix_to_infix(exp.text.toString(), java.util.Stack())
                res.setText(ans)
            }
        } else if (value.equals("b")) {
            bt43.setOnClickListener {
                var ans: String = postfix_to_prefix(exp.text.toString(), java.util.Stack(), Stack())
                res.setText(ans)
            }
        } else if (value.equals("c")) {
            bt43.setOnClickListener {
                var ans: String = prefix_to_infix(exp.text.toString(), java.util.Stack())
                res.setText(ans)
            }
        } else if (value.equals("d")) {
            bt43.setOnClickListener {
                var ans: String = prefix_to_postfix(exp.text.toString(), java.util.Stack(), Stack())
                res.setText(ans)
            }
        } else if (value.equals("e")) {
            bt43.setOnClickListener {
                var ans: String = infix_to_postfix(exp.text.toString(), Stack())
                res.setText(ans)
            }
        } else if (value.equals("f")) {
            bt43.setOnClickListener {
                var ans: String = infix_to_prefix(exp.text.toString(), Stack())
                res.setText(ans)
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

    fun postfix_to_infix(exp: String, stack: java.util.Stack<String>): String {

        for (i in 0..exp.length - 1) {

            val ch = exp.elementAt(i)
            if (ch >= '0' && ch <= '9') {
                stack.push(exp.substring(i, i + 1))
            } else {
                val a = stack.pop()
                val b = stack.pop()
                var c = b + exp.substring(i, i + 1) + a
                c = "($c)"
                stack.push(c)
            }
        }

        return stack.peek()

    }

    fun postfix_to_prefix(exp: String, stack: java.util.Stack<String>, stack2: Stack): String {

        for (i in 0..exp.length - 1) {

            val ch = exp.elementAt(i)
            if (ch >= '0' && ch <= '9') {
                stack.push(exp.substring(i, i + 1))
            } else {
                val a = stack.pop()
                val b = stack.pop()
                var c = b + exp.substring(i, i + 1) + a
                c = "($c)"
                stack.push(c)
            }
        }

        var exp2: String = stack.peek()

        var exp1 = exp2.reversed()

        var ans = ""
        var temp = 0
        for (i in 0..exp1.length - 1) {

            val ch = exp1.elementAt(i)
            if (ch >= '0' && ch <= '9') {
                ans += exp1.substring(i, i + 1)
            } else if (ch == '(') {
                stack2.push(ch.toInt())
            } else if (ch == ')') {
                while (stack2.top() !== '('.toInt()) {
                    val rv = stack2.pop()
                    ans += cts(rv.toChar())
                }
            } else {
                if (temp == 0) {
                    stack2.push(ch.toInt())
                    temp = 1
                } else {
                    if (stack2.top() === 40) {
                        stack2.push(ch.toInt())
                    } else if (stack2.top().toInt() < ch.toInt()) {
                        stack2.push(ch.toInt())
                    } else if (stack2.top() as Int >= ch.toInt()) {
                        while (stack2.isEmpty || stack2.top().toInt() < ch.toInt()) {
                            val rv = stack2.pop()
                            print(rv)
                            ans += cts(rv.toChar())
                        }
                        stack2.push(ch.toInt())
                    }
                }
            }

        }
        while (!stack2.isEmpty) {
            val rv = stack2.pop()
            if (rv != 40) {
                ans += cts(rv.toChar())
            }
        }

        var ans2 = ans.reversed()

        return ans2

    }

    fun prefix_to_infix(exp2: String, stack: java.util.Stack<String>): String {

        var exp = exp2.reversed()

        for (i in 0..exp.length - 1) {

            val ch = exp.elementAt(i)
            if (ch >= '0' && ch <= '9') {
                stack.push(exp.substring(i, i + 1))
            } else {
                val a = stack.pop()
                val b = stack.pop()
                var c = a + exp.substring(i, i + 1) + b
                c = "($c)"
                stack.push(c)
            }
        }

        return stack.peek()


    }

    fun prefix_to_postfix(exp2: String, stack: java.util.Stack<String>, stack2: Stack): String {

        var exp = exp2.reversed()

        for (i in 0..exp.length - 1) {

            val ch = exp.elementAt(i)
            if (ch >= '0' && ch <= '9') {
                stack.push(exp.substring(i, i + 1))
            } else {
                val a = stack.pop()
                val b = stack.pop()
                var c = a + exp.substring(i, i + 1) + b
                c = "($c)"
                stack.push(c)
            }
        }
        var exp1: String = stack.peek()

        var ans = ""
        var temp = 0
        for (i in 0..exp1.length - 1) {

            val ch = exp1.elementAt(i)
            if (ch >= '0' && ch <= '9') {
                ans += exp1.substring(i, i + 1)
            } else if (ch == '(') {
                stack2.push(ch.toInt())
            } else if (ch == ')') {
                while (stack2.top() !== '('.toInt()) {
                    val rv = stack2.pop()
                    ans += cts(rv.toChar())
                }
            } else {
                if (temp == 0) {
                    stack2.push(ch.toInt())
                    temp = 1
                } else {
                    if (stack2.top() === 40) {
                        stack2.push(ch.toInt())
                    } else if (stack2.top().toInt() < ch.toInt()) {
                        stack2.push(ch.toInt())
                    } else if (stack2.top() as Int >= ch.toInt()) {
                        while (stack2.isEmpty || stack2.top().toInt() < ch.toInt()) {
                            val rv = stack2.pop()
                            print(rv)
                            ans += cts(rv.toChar())
                        }
                        stack2.push(ch.toInt())
                    }
                }
            }

        }
        while (!stack2.isEmpty) {
            val rv = stack2.pop()
            if (rv != 40) {
                ans += cts(rv.toChar())
            }
        }

        return ans


    }

    fun infix_to_postfix(exp: String, stack: Stack): String {

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

        return ans

    }

    fun infix_to_prefix(exp2: String, stack: Stack): String {

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

        return ans2

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
