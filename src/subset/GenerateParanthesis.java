package subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Paranthesis {
    String str;
    int openCount;
    int closeCount;
    Paranthesis(String str, int openCount, int closeCount) {
        this.openCount = openCount;
        this.closeCount = closeCount;
        this.str = str;
    }
}
public class GenerateParanthesis {

        public List<String> generateParenthesis(int num) {
            Queue<Paranthesis> queue = new LinkedList<>();
            queue.add(new Paranthesis("", 0, 0));
            List<String> res = new ArrayList<>();
            while (!queue.isEmpty()) {
                Paranthesis ps = queue.poll();
                if (ps.openCount == num && ps.closeCount == num) {
                    res.add(ps.str);
                } else {
                    if (ps.openCount < num) {
                        queue.add(new Paranthesis(ps.str + "(", ps.openCount + 1, ps.closeCount));
                    }

                    if (ps.closeCount < ps.openCount) {
                        queue.add(new Paranthesis(ps.str + ")", ps.openCount, ps.closeCount + 1));
                    }
                }

            }
            return res;
        }
}
