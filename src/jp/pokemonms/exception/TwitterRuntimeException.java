package jp.pokemonms.exception;

/**
 * TwitterAPI例外
 *
 * @author sin
 *
 */
public class TwitterRuntimeException extends RuntimeException {

    /** シリアルID */
    private static final long serialVersionUID = 1L;

    /** プロパティ */
    protected String property = "error";

    /**
     * デフォルトコンストラクタ
     *
     */
    public TwitterRuntimeException() {
        super();
    };

    /**
     * コンストラクタ
     *
     * @param throwable
     */
    public TwitterRuntimeException(Throwable throwable) {
        super(throwable);
    }

    /**
     * 指定された詳細メッセージを使用して、新規例外を構築
     *
     * @param message
     */
    public TwitterRuntimeException(String message) {
        super(message);
    }

    /**
     * 指定された詳細メッセージを使用して、新規例外を構築
     *
     * @param message
     * @param property
     */
    public TwitterRuntimeException(String message, String property) {
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