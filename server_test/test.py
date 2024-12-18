import requests
import read_file
import time
import json

cool = False

param_map = {
    '低': ['http://127.0.0.1:8082/api/change_ac_mode', {'roomId': "1", 'acMode': 0, 'cool': cool}],
    '中': ['http://127.0.0.1:8082/api/change_ac_mode', {'roomId': "1", 'acMode': 1, 'cool': cool}],
    '高': ['http://127.0.0.1:8082/api/change_ac_mode', {'roomId': "1", 'acMode': 2, 'cool': cool}],
    '开机': ['http://127.0.0.1:8082/api/turn_on_ac', {'roomId': "1", 'acTemperature': 22, 'acMode': 1, 'acOn': True, 'cool': cool}],
    '关机': ['http://127.0.0.1:8082/api/turn_off_ac', {'roomId': "1", 'acTemperature': 22, 'acMode': 1, 'acOn': False, 'cool': cool}],
    'digits': ['http://127.0.0.1:8082/api/change_ac_temp', {'roomId': "1", 'acTemperature': 22, 'cool': cool}]
}

tic_sec = 2.
rooms = ['1', '2', '3', '4', '5']

res_list = []
queue_list = []
cost_list = []


session = requests.Session()
session.cookies.set("token", "Jerry:123123")


def post_req(url, param):
    print(url, param)
    res = session.post(url=url, json=param)
    # print(res.text)


def get_queue():
    res = session.get('http://127.0.0.1:8082/api/show_queue')
    queue_list.append(json.loads(res.text))


def init_rooms():
    res = session.get("http://127.0.0.1:8082/api/init")
    print("init:", res)


def get_all_status():
    res = session.get("http://127.0.0.1:8082/api/get_room_status")
    print(res.text)
    return res


def get_room_cost(room_id):
    res = session.get("http://127.0.0.1:8082/api/get_room_cost?roomId=" + room_id)
    return res.text


def get_logs():  # 详单
    ret = []
    for room_id in rooms:
        res = session.get(f"http://127.0.0.1:8082/api/get_room_logs?roomId={room_id}")
        ret.append(res.json())
    return ret


def fuck(data_list):
    init_rooms()
    for i in range(len(data_list)):
        start = time.time()
        for j in range(len(data_list[i])):
            for data in data_list[i][j]:
                if len(data) <= 0:
                    continue
                if data in param_map:
                    param = param_map[data][1]
                    param['roomId'] = str(j + 1)
                    post_req(param_map[data][0], param)
                else:
                    param = param_map['digits'][1]
                    param['roomId'] = str(j + 1)
                    param['acTemperature'] = int(data)
                    post_req(param_map['digits'][0], param)
        status = get_all_status().json()
        res_list.append(status)
        get_queue()
        print(i + 1, "finish")
        end = time.time()
        time.sleep(max(0., tic_sec - (end - start)))


if __name__ == '__main__':
    fuck(read_file.get_data())
    for room_id in rooms:
        cost_list.append(get_room_cost(room_id))
    print(res_list)
    read_file.dict2xlsx(res_list, get_logs(), queue_list, cost_list)
    # show_queue()
