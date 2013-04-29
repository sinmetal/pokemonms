package jp.pokemonms.exception;

/**
 * NotFoundException
 *
 * @author Sinmetal
 *
 */
public class NotFoundRuntimeException extends RuntimeException {

    /** シリアルID */
    private static final long serialVersionUID = 1L;

    /** プロパティ */
    protected String property = "error";

    /**
     * デフォルトコンストラクタ
     *
     */
    public NotFoundRuntimeException() {
        super();
    };

    /**
     * コンストラクタ
     *
     * @param throwable
     */
    public NotFoundRuntimeException(Throwable throwable) {
        super(throwable);
    }

    /**
     * 指定された詳細メッセージを使用して、新規例外を構築
     *
     * @param message
     */
    public NotFoundRuntimeException(String message) {
        super(message);
    }

    /**
     * 指定された詳細メッセージを使用して、新規例外を構築
     *
     * @param message
     * @param property
     */
    public NotFoundRuntimeException(String message, String property) {
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