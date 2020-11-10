package ru.job4j.srp.report;

import ru.job4j.srp.storage.Store;

public abstract class ReportProgrammers extends ReportEngine {
    public ReportProgrammers(Store store) {
        super(store);
    }
}
