/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if (obj === null || obj === undefined || typeof classFunction !== 'function') {
        return false;
    }
    let curr = Object(obj);

    while (curr !== null) {
        if (Object.getPrototypeOf(curr) === classFunction.prototype) {
            return true;
        }
        curr = Object.getPrototypeOf(curr);
    }

    return false;
};
