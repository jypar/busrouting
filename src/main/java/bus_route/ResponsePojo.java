package bus_route;

public class ResponsePojo {
    private final int from;
    private final int to;
    private final boolean direct;
    public ResponsePojo(int from, int to, boolean direct) {
        this.from = from;
        this.to = to;
        this.direct = direct;
    }

    public int getFrom() {
        return from;
    }
    public int getTo() {
        return to;
    }
    public boolean getDirect() {
        return direct;
    }


}
