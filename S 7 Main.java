/ Command interface
interface Command {
    void execute();
    void undo();
}

// Receiver class
class CeilingFan {
    public void on() {
        System.out.println("Ceiling fan is ON");
    }

    public void off() {
        System.out.println("Ceiling fan is OFF");
    }
}

// Concrete Command - Turn Fan ON
class CeilingFanOnCommand implements Command {
    CeilingFan fan;

    public CeilingFanOnCommand(CeilingFan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.on();
    }

    public void undo() {
        fan.off();
    }
}

// Concrete Command - Turn Fan OFF
class CeilingFanOffCommand implements Command {
    CeilingFan fan;

    public CeilingFanOffCommand(CeilingFan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.off();
    }

    public void undo() {
        fan.on();
    }
}

// Invoker class
class SimpleRemoteControl {
    Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }

    public void undoButtonWasPressed() {
        slot.undo();
    }
}

// Client class
public class Main {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        CeilingFan ceilingFan = new CeilingFan();

        CeilingFanOnCommand fanOn = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand fanOff = new CeilingFanOffCommand(ceilingFan);

        System.out.println("--- Turning Fan ON ---");
        remote.setCommand(fanOn);
        remote.buttonWasPressed();
        remote.undoButtonWasPressed();

        System.out.println("\n--- Turning Fan OFF ---");
        remote.setCommand(fanOff);
        remote.buttonWasPressed();
        remote.undoButtonWasPressed();
    }
}