goog.provide('common.ajax');
goog.require('goog.Uri');
goog.require('goog.net.XhrManager');
goog.require('goog.soy');

goog.scope(function(){
    var gdom = goog.dom;
    var gsoy = goog.soy;
    
    /** @constructor */
    common.ajax = function(){
        this.initialize_();
    };
    goog.addSingletonGetter(common.ajax);
    
    /**
     * initialize.
     *
     * @private
     */
    common.ajax.prototype.initialize_ = function(){
        this.xhrManager_ = new goog.net.XhrManager();
        this.nextXhrId_ = 1;
    };
    
    /**
     * ajax send request.
     *
     * @param {Object}
     *            path
     * @param {Object}
     *            query
     * @param {Object}
     *            callback
     * @param {Object}
     *            method
     * @param {Object}
     *            opt_content
     */
    common.ajax.prototype.sendRequest = function(path, query, callback, method, opt_content){
        var url = goog.Uri.parse(path);
        goog.object.forEach(query || {}, function(value, key){
            url.setParameterValue(key, value);
        }, this);
        var headers = {}, body = null;
        if (opt_content) {
            body = goog.json.serialize(opt_content);
            headers['Content-Type'] = 'application/json';
        }
        return this.xhrManager_.send(this.nextXhrId_++, url, method, body, headers, 0, goog.bind(this.processRequest_, this, callback), 5);
    };
    
    /**
     * ajax request process method.
     * @param {Object} callback
     * @param {Object} e
     */
    common.ajax.prototype.processRequest_ = function(callback, e){
        var xhr = e.target;
        var error = gdom.getElement('error-message');
        if (xhr.isSuccess()) {
            callback && callback(xhr.getResponseJson('while(1);'));
        } else {
            if (!error) {
                gdom.removeChildren(error);
                gdom.append(error, gsoy.renderAsElement(templates.alerts.error));
            } else {
                alert('errorが発生しました。時間をおいて再度お試しください。');
            }
            return;
        }
    };
    
    /**
     * common ajax get instance.
     */
    common.ajax.getInstance();
});
