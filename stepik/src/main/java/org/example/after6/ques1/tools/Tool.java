package org.example.after6.ques1.tools;

public abstract class Tool {

    private Tool in = null;

    public Tool(Tool in) {
        this.in = in;
    }

    public Tool() {
    }

    protected abstract void use();

    public final void work() {
        if (in != null) {
            in.work();
        }
        use();
    };
}

