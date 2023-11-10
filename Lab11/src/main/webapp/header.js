function requestHeader(x, y, z) {
    const pattern = /^[0-9]*\.?[0-9]+$/;
    if (pattern.test(x) && pattern.test(y)) {
        let req = crReq();
        if (req) {
            req.open('POST', 'http://localhost:8080/AJAX/sss_header', isRequestAsync);
            req.onreadystatechange = function () {
                if (req.readyState === 4) {
                    if (req.status === 200) {
                        z.value = req.getResponseHeader('Value-Z');
                    } else alert(`status = ${req.status}\n${req.statusText}`);
                }
            };
            req.setRequestHeader('Value-X', x);
            req.setRequestHeader('Value-Y', y);
            req.send('null');
        }
    } else alert('error');
}