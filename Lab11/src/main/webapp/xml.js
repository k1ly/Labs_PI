function fillXML(req) {
    const xmlDoc = req.responseXML;
    let tsNum = xmlDoc.getElementsByTagName('num');
    let rc = '';
    for (let i = 0; i < tsNum.length; i++) {
        rc += `${tsNum[i].textContent} `;
    }
    return (rc);
}

function requestXML(n, s) {
    const pattern = /^[1-9]+[0-9]*$/;
    if (pattern.test(n)) {
        let req = crReq();
        if (req) {
            req.open('POST', 'http://localhost:8080/AJAX/sss_xml', isRequestAsync);
            req.onreadystatechange = function () {
                if (req.readyState === 4) {
                    if (req.status === 200) {
                        s.firstChild.data = fillXML(req);
                        s.className = 'h1';
                    } else alert(`status = ${req.status}\n${req.statusText}`);
                }
            };
            req.setRequestHeader('XRand-N', n)
            req.send('null');
        }
    } else alert('error');
}
