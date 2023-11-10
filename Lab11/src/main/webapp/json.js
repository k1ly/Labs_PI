function fillJSON(req) {
    const xx = eval(`(${req.responseText})`);
    let rc = '';
    for (let i = 0; i < xx.X.length; i++) {
        rc += `${xx.X[i].rand} `;
    }
    return (rc);
}

function requestJSON(n, s) {
    const pattern = /^[1-9]+[0-9]*$/;
    if (pattern.test(n)) {
        let req = crReq();
        if (req) {
            req.open('POST', 'http://localhost:8080/AJAX/sss_json', isRequestAsync);
            req.onreadystatechange = function () {
                if (req.readyState === 4) {
                    if (req.status === 200) {
                        s.firstChild.data = fillJSON(req);
                        s.className = 'h1';
                    } else alert('status = ' +
                        req.status + '\n' + req.statusText);
                }
            };
            req.setRequestHeader('XRand-N', n);
            req.send('null');
        }
    } else alert('error');
}
