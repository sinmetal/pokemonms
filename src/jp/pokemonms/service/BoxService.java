package jp.pokemonms.service;

import jp.pokemonms.exception.DatastorePutErrorException;
import jp.pokemonms.form.storage.BoxForm;
import jp.pokemonms.model.Member;
import jp.pokemonms.model.json.storage.box.RookieBox;

import org.apache.commons.lang3.tuple.Pair;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.datastore.TransactionOptions;

/**
 * ボックス用サービス
 * 
 * @author Sinmetal
 * 
 */
public class BoxService {

    /** MemberService */
    private final MemberService memberService = new MemberService();

    /** 育成前ポケモンService */
    private final RookieBoxService rookieBoxService = new RookieBoxService();

    /**
     * 育成前ポケモンBoxを登録
     * 
     * @param memberKey 登録するメンバーのkey
     * @param form BoxForm
     * @return 登録成功:true, 登録失敗:false
     */
    public Pair<Key, Key> put4RookieBox(Key memberKey, BoxForm form) {
        final RookieBox box = RookieBox.getInstance(memberKey, form);
        final Member member = memberService.get(memberKey);
        DatastoreService datastoreService =
            DatastoreServiceFactory.getDatastoreService();
        TransactionOptions txOps = TransactionOptions.Builder.withXG(true);

        Transaction tx = datastoreService.beginTransaction(txOps);
        try {
            final Key rookieBoxKey = rookieBoxService.put(tx, box);
            member.addBoxKey(rookieBoxKey);
            Datastore.put(tx, member);
            tx.commit();
            return Pair.of(memberKey, rookieBoxKey);
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
                throw new DatastorePutErrorException();
            }
        }
    }

}
