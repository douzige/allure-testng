package servers;

/**
 * @author ceshi_chen
 * @version $Id: StringToolImpl,  2019/5/21 17:09 ceshi_chen Exp$
 */
public class StringToolImpl implements StringTool {
    @Override
    public String tolow(String str) {
        return str.toLowerCase();
    }

    @Override
    public String toUpp(String str) {
        return str.toUpperCase();
    }
}
