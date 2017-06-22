var Brewer = Brewer || {};

Brewer.MaskMoney = (function () {

    function MaskMoney(){
        this.decimal = $('.js-decimal');
        this.inteiro = $('.js-plain');
    }

    MaskMoney.prototype.enable = function(){
        this.decimal.maskMoney({decimal: ',', thousands: '.' });
        this.inteiro.maskMoney({precision: 0, thousands: '.'});
    };

    return MaskMoney;
}());

Brewer.MaskPhoneNumber = (function () {

    function MaskPhoneNumber() {
        this.inputPhone = $('.js-phone-number');
    }

    MaskPhoneNumber.prototype.enable = function(){
        var maskBehavior = function (val) {
            return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
        };

        var options = {
            clearIfNotMatch: true, // Limpa o campo se não corresponder ao padrão
            onKeyPress: function(val, e, field, options) {
                field.mask(maskBehavior.apply({}, arguments), options);
            }
        };
        this.inputPhone.mask(maskBehavior, options);
    };

    return MaskPhoneNumber;

})();

Brewer.MaskCep = (function(){

    function MaskCep() {
        this.inputCep = $('.js-cep');
    }

    MaskCep.prototype.enable = function(){
        this.inputCep.mask('00.000-000');
    };

    return MaskCep;

}());

$(function () {
    var maskMoney = new Brewer.MaskMoney();
    maskMoney.enable();

    var maskPhoneNumber = new Brewer.MaskPhoneNumber();
    maskPhoneNumber.enable();

    var maskCep = new Brewer.MaskCep();
    maskCep.enable();

    //Initialize Select2 Elements
    $(".select2").select2();
});
