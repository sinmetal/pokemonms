package jp.pokemonms.var;

import java.util.HashMap;
import java.util.Map;

import jp.pokemonms.model.constant.StatusType;

/**
 * 個体値用ステータス
 * 
 * 個体値は他のステータスと比べて、測定値に幅が出てしまうので、それを許容するロジックを有する
 * 
 * @author Sinmetal
 * 
 */
public class PokemonStatus4Individual {

    private Map<StatusType, IndividualStatusValue> statusMap;

    public PokemonStatus4Individual() {
        this.statusMap = new HashMap<StatusType, IndividualStatusValue>();
        for (StatusType type : StatusType.getAll()) {
            this.statusMap.put(type, new IndividualStatusValue());
        }
    }

    public void set(StatusType type, int value) {
        IndividualStatusValue status = this.statusMap.get(type);
        status.setStatus(value);
    }

    public Map<String, String> asMap() {
        Map<String, String> map = new HashMap<String, String>();
        for (StatusType type : statusMap.keySet()) {
            map.put(type.getSign(), statusMap.get(type).getViewText());
        }
        return map;
    }

    private class IndividualStatusValue {
        private final int UPPER_DEFAULT_VALUE = Integer.MIN_VALUE;
        private final int LOWER_DEFAULT_VALUE = Integer.MAX_VALUE;
        private final String UNCLEAR = "?";

        private Integer upper = UPPER_DEFAULT_VALUE;

        private Integer lower = LOWER_DEFAULT_VALUE;

        public IndividualStatusValue() {
        }

        /**
         * get view text
         * 
         * @return
         */
        public String getViewText() {
            if (!isExist()) {
                return UNCLEAR;
            }
            if (this.upper == this.lower) {
                return this.upper.toString();
            }
            return String.format("%s-%s", this.lower, this.upper);
        }

        /**
         * set status parameter.<br/>
         * 上限値と下限値、共に大小判定を行い設定する
         * 
         * @param value
         */
        public void setStatus(int value) {
            if (this.upper < value) {
                this.upper = value;
            }
            if (this.lower > value) {
                this.lower = value;
            }
        }

        /**
         * upper and lower not default value
         * 
         * @return
         */
        private boolean isExist() {
            return (this.upper != UPPER_DEFAULT_VALUE && this.lower != LOWER_DEFAULT_VALUE);
        }
    }
}
