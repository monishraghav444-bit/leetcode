/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    // classFunction must actually be a function/constructor
    if (typeof classFunction !== 'function') return false;
    
    // null and undefined are never instances of anything
    if (obj === null || obj === undefined) return false;
    
    // Wrap primitives (numbers, strings, booleans, symbols, bigints) so they
    // have a prototype chain to walk, just like their object counterparts.
    if (typeof obj !== 'object' && typeof obj !== 'function') {
        obj = Object(obj);
    }
    
    // Walk up the prototype chain looking for classFunction.prototype
    let proto = Object.getPrototypeOf(obj);
    const target = classFunction.prototype;
    
    while (proto !== null) {
        if (proto === target) {
            return true;
        }
        proto = Object.getPrototypeOf(proto);
    }
    
    return false;
};
