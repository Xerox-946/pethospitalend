


/**

  * 加密

  *@param word：需要加密的内容

  *@returns {*} ：返回加密的内容

  */
//
// function encrypt(word) {
//
//     var key = CryptoJS.enc.Utf8.parse("yxkj123456123456");
//
//     var srcs =CryptoJS.enc.Utf8.parse(word);
//
//     var encrypted =CryptoJS.AES.encrypt(srcs, key, { mode: CryptoJS.mode.ECB, padding:CryptoJS.pad.Pkcs7 });
//
//     return encrypted.toString();
//
// }
//
//
//
// /**
//
//       * 解密
//
//       * @param word
//
//       * @returns {*}
//
//       */
//
// function decrypt(word){
//     var key = CryptoJS.enc.Utf8.parse("yxkj123456123456");
//     var decrypt = CryptoJS.AES.decrypt(word, key, {mode:CryptoJS.mode.ECB,padding: CryptoJS.pad.Pkcs7});
//     return CryptoJS.enc.Utf8.stringify(decrypt).toString();
// }
//

/**
 * 工具类
 */


// 默认的 KEY 与 iv 如果没有给
var KEY = CryptoJS.enc.Utf8.parse('1234567890123456');
var IV = CryptoJS.enc.Utf8.parse('1234567890123456');

/**
 * AES加密 ：字符串 key iv  返回base64
 */
 function Encrypt (word, keyStr, ivStr) {
    var key = KEY;
    var iv = IV;

    if (keyStr) {
        key = CryptoJS.enc.Utf8.parse(keyStr);
        iv = CryptoJS.enc.Utf8.parse(ivStr)
    }

    var srcs = CryptoJS.enc.Utf8.parse(word);
    var encrypted = CryptoJS.AES.encrypt(srcs, key, {
        iv: iv,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.ZeroPadding
    });
    // console.log("-=-=-=-", encrypted.ciphertext)
    return CryptoJS.enc.Base64.stringify(encrypted.ciphertext)
}

/**
 * AES 解密 ：字符串 key iv  返回base64
 *
 */ function Decrypt (word, keyStr, ivStr) {
    var key = KEY;
    var iv = IV;
    if (keyStr) {
        key = CryptoJS.enc.Utf8.parse(keyStr);
        iv = CryptoJS.enc.Utf8.parse(ivStr);
    }
    var base64 = CryptoJS.enc.Base64.parse(word);
    var src = CryptoJS.enc.Base64.stringify(base64);

    var decrypt = CryptoJS.AES.decrypt(src, key, {
        iv: iv,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.ZeroPadding
    });
    var decryptedStr = decrypt.toString(CryptoJS.enc.Utf8);
    return decryptedStr.toString()
}
