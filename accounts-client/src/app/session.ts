export class Session {
  private objects: Map<String, Object>;

  constructor() {
    this.objects = new Map<String, Object>()
  }

  set(key: String, value: Object): void {
    this.objects.set(key, value);
  }

  get(key: String): Object {
    return this.objects.get(key);
  }
}
