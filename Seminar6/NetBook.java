public class NetBook {

    private String model;
    private String cpu;
    private Integer memory;
    private double display;
    private Integer serialNumber;
    
    public void setModel(String model) {
        this.model = model;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public void setDisplay(double d) {
        this.display = d;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public NetBook(){

    }

    @Override
    public String toString() {
        return "NetBook [model=" + model + ", cpu=" + cpu + ", memory=" + memory + ", display=" + display
                + ", serialNumber=" + serialNumber + "]";
    }

    
}
