package ParkingLot.MultiStorey.gates;

import java.util.List;

// Handles multiple entry and exit gates, and assigns a vehicle to the appropriate gate.
public class GateManager {
    private final List<EntryGate> entryGateList;
    private final List<ExitGate> exitGateList;

    public GateManager(List<EntryGate> entryGateList, List<ExitGate> exitGateList) {
        this.entryGateList = entryGateList;
        this.exitGateList = exitGateList;
    }

    public EntryGate getAvailableEntryGate() {
        for(EntryGate entryGate: entryGateList) {
            if(entryGate.isAvailable())
                return entryGate;
        }

        throw new IllegalArgumentException("No entry gate available");
    }

    public ExitGate getAvailableExitGate() {
        for(ExitGate exitGate: exitGateList) {
            if(exitGate.isAvailable())
                return exitGate;
        }

        throw new IllegalArgumentException("No exit gate available");
    }
}
