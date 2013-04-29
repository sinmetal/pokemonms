package jp.pokemonms.exception;

/**
 * Config誤り例外
 * @author Sinmetal
 *
 */
public class ConfigRuntimeException extends RuntimeException {

    /** シリアルID */
    private static final long serialVersionUID = 1L;

    /** プロパティ */
    protected String property = "error";

    /**
     * デフォルトコンストラクタ
     *
     */
    public ConfigRuntimeException() {
        super();
    };

    /**
     * コンストラクタ
     *
     * @param throwable
     */
    public ConfigRuntimeException(Throwable throwable) {
        super(throwable);
    }

    /**
     * 指定された詳細メッセージを使用して、新規例外を構築
     *
     * @param message
     */
    public ConfigRuntimeException(String message) {
        super(message);
    }

    /**
     * 指定された詳細メッセージを使用して、新規例外を構築
     *
     * @param message
     * @param property
     */
    public ConfigRuntimeException(String message, String property) {
        super(message);
        this.property = property;
    }

    /**
     * プロパティ取得
     *
     * @return
     */
    public String getProperty() {
        return property;
    }

}
