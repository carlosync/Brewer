
$(function () {
    var decimal = $('.js-decimal');
    decimal.maskMoney({decimal: ',', thousands: '.' });

    var inteiro = $('.js-plain');
    inteiro.maskMoney({precision: 0, thousands: '.'});
});
