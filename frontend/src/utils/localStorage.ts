class StoragedValues {
  private static instance: StoragedValues;

  private localStorageInstance: Storage;

  private defaultToken: string;

  private defaultId: string;

  private constructor() {
    this.localStorageInstance = localStorage;
    this.defaultToken = "not_auth";
    this.defaultId = "-1"
  };

  public static getInstance(): StoragedValues {
    if (!StoragedValues.instance) {
      StoragedValues.instance = new StoragedValues();
    };

    return StoragedValues.instance;
  };

  /**
   * Set values
   */

  public setToken(s: string): void {
    this.localStorageInstance.setItem('@authToken', s);
  };

  public setId(s: string): void {
    this.localStorageInstance.setItem('@authId', s);
  };


  /**
   * Get values
   */

  public getToken(): string {
    if (!localStorage.getItem('@authToken'))
      this.setToken(this.getDefaultToken());

    return localStorage.getItem('@authToken') || this.getDefaultToken();
  };

  public getId(): string {
    if (!localStorage.getItem('@authId'))
      this.setId(this.getDefaultId());

    return localStorage.getItem('@authId') || this.getDefaultId();
  };


  /**
   * Default values
   */
  public getDefaultToken(): string {
    return this.defaultToken;
  };

  public getDefaultId(): string {
    return this.defaultId;
  };


  /**
   * Set as default
   */
  public setTokenAsDefault(): void {
    this.localStorageInstance.setItem('@authToken', this.defaultToken);
  };

  public setIdAsDefault(): void {
    this.localStorageInstance.setItem('@authId', this.defaultId);
  };


  /**
   * Clear values
   */
  public clearToken() {
    this.localStorageInstance.removeItem('@authToken');
  };

  public clearId() {
    this.localStorageInstance.removeItem('@authId');
  };
};

export default StoragedValues.getInstance();
