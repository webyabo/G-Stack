package cn.com.autohome.GStack.Basic.DSL;

import cn.com.autohome.Basic.StoreUtils;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.datastore.DataStore;

import static cn.com.autohome.Basic.Core.fillArgs;
import static com.thoughtworks.gauge.datastore.DataStoreFactory.*;

public class Store {
    @Step("SET:SUITE <name> <value>")
    public void storeSuite(String name, String value) {
        name = fillArgs(name);
        value = fillArgs(value);
        suiteDataStore.put(name, value);
    }

    @Step("SET:SPEC <name> <value>")
    public void storeSpec(String name, String value) {
        name = fillArgs(name);
        value = fillArgs(value);
        specDataStore.put(name, value);
    }

    @Step("SET:SCENARIO <name> <value>")
    public void storeScenario(String name, String value) {
        name = fillArgs(name);
        value = fillArgs(value);
        scenarioDataStore.put(name, value);
    }

    @Step("SET:SUITE <table>")
    public void storesSuite(Table table) {
        StoreUtils.storeTable(table, suiteDataStore);
    }

    @Step("SET:SPEC <table>")
    public void storesSpec(Table table) {
        StoreUtils.storeTable(table, specDataStore);
    }

    @Step("SET:SCENARIO <table>")
    public void storesScenario(Table table) {
        StoreUtils.storeTable(table, scenarioDataStore);
    }


    private final DataStore scenarioDataStore = getScenarioDataStore();
    private final DataStore specDataStore = getSpecDataStore();

    private final DataStore suiteDataStore = getSuiteDataStore();

}
