import SanitizerString from './sanitizerString'

// ----------------------------------------------------------------------

export const isNotEmpty = (s: string): boolean => (SanitizerString.stringOrEmpty(s) !== "");

// https://html.spec.whatwg.org/multipage/input.html#valid-e-mail-address
export const isEmail = (s: string): boolean => (
  /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/
    .test(s)
);