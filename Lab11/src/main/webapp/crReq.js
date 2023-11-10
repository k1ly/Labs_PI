function crReq() {
    console.log('crReq');
    let req = null;
    if (window.XMLHttpRequest) {
        req = new window.XMLHttpRequest();
        console.log('req = XMLHttpRequest');
    } else if (window.ActiveXObject) {
        try {
            req = new ActiveXObject('Msxml2.XMLHTTP');
            console.log('req = Msxml2.XMLHTTP');
        } catch (e) {
            try {
                req = new ActiveXObject('Microsoft.XMLHTTP');
                console.log('req = Microsoft.XMLHTTP');
            } catch (e) {
                req = null;
                console.log('req = null');
            }
        }
    }
    return req;
}
