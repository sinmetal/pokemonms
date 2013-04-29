package jp.pokemonms.var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.pokemonms.model.constant.StatusType;

public class PokemonStatus {

    private static final int DEFAULT_VALUE = -1;

    private HashMap<StatusType, Integer> statusMap =
        new HashMap<StatusType, Integer>();

    public PokemonStatus() {
        for (StatusType type : StatusType.getAll()) {
            statusMap.put(type, DEFAULT_VALUE);
        }
    }

    public PokemonStatus(Integer h, Integer a, Integer b, Integer c, Integer d,
            Integer s) {
        putStatus(StatusType.H, h);
        putStatus(StatusType.A, a);
        putStatus(StatusType.B, b);
        putStatus(StatusType.C, c);
        putStatus(StatusType.D, d);
        putStatus(StatusType.S, s);
    }

    public int get(StatusType statusType) {
        return statusMap.get(statusType);
    }

    public void set(StatusType statusType, Integer value) {
        statusMap.put(statusType, value);
    }

    public Map<StatusType, Integer> asMap() {
        return statusMap;
    }

    public List<Integer> asList() {
        ArrayList<Integer> statusList = new ArrayList<Integer>();
        for (StatusType type : StatusType.getAll()) {
            statusList.add(statusMap.get(type));
        }
        return statusList;
    }

    public int getH() {
        return statusMap.get(StatusType.H);
    }

    public void setH(Integer h) {
        statusMap.put(StatusType.H, h);
    }

    public int getA() {
        return statusMap.get(StatusType.A);
    }

    public void setA(Integer a) {
        statusMap.put(StatusType.A, a);
    }

    public int getB() {
        return statusMap.get(StatusType.B);
    }

    public void setB(Integer b) {
        statusMap.put(StatusType.B, b);
    }

    public int getC() {
        return statusMap.get(StatusType.C);
    }

    public void setC(Integer c) {
        statusMap.put(StatusType.C, c);
    }

    public int getD() {
        return statusMap.get(StatusType.D);
    }

    public void setD(Integer d) {
        statusMap.put(StatusType.D, d);
    }

    public int getS() {
        return statusMap.get(StatusType.S);
    }

    public void setS(Integer s) {
        statusMap.put(StatusType.S, s);
    }

    public boolean isExistH() {
        return isExist(StatusType.H);
    }

    public boolean isExistA() {
        return isExist(StatusType.A);
    }

    public boolean isExistB() {
        return isExist(StatusType.B);
    }

    public boolean isExistC() {
        return isExist(StatusType.C);
    }

    public boolean isExistD() {
        return isExist(StatusType.D);
    }

    public boolean isExistS() {
        return isExist(StatusType.S);
    }

    public boolean isExist(StatusType statusType) {
        return (statusMap.get(statusType) != DEFAULT_VALUE);
    }

    private void putStatus(StatusType statusType, Integer value) {
        if (value == null) {
            statusMap.put(statusType, DEFAULT_VALUE);
        } else {
            statusMap.put(statusType, value);
        }
    }
}
