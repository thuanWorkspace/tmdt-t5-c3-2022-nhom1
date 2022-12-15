import React from "react";

export default function FooterItem({ name, listItem }) {
  return (
    <ul className="">
      <h3 className="">{name}</h3>

      {listItem.map((item, index) => (
        <li className="" key={index}>
          {item}
        </li>
      ))}
    </ul>
  );
}
