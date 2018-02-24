package design_patterns.state;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/9/11.
 */
public class StateObject {

    private LightState state;

    private String name;

    public LightState getState() {
        return state;
    }

    public void setState(LightState state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
