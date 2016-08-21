/**
 * Created by Carlos on 21/08/16.
 */

$(function () {
    var decimal = $('.js-decimal');
    decimal.maskMoney();

    var inteiro = $('.js-plain');
    inteiro.maskMoney({precision: 0});
});
